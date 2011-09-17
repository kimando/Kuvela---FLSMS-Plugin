/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.medicmobile.projects.desktop.kuvela.reader;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import javax.crypto.spec.SecretKeySpec;
import org.medicmobile.projects.desktop.kuvela.controllers.KuvelaControllersInterface;
import org.smslib.AGateway;
import org.smslib.AGateway.GatewayStatuses;
import org.smslib.AGateway.Protocols;
import org.smslib.ICallNotification;
import org.smslib.IGatewayStatusNotification;
import org.smslib.IInboundMessageNotification;
import org.smslib.IOrphanedMessageNotification;
import org.smslib.InboundBinaryMessage;
import org.smslib.InboundEncryptedMessage;
import org.smslib.InboundMessage;
import org.smslib.Message.MessageEncodings;
import org.smslib.Message.MessageTypes;
import org.smslib.OutboundMessage;
import org.smslib.Service;
import org.smslib.USSDRequest;
import org.smslib.crypto.AESKey;
import org.smslib.modem.SerialModemGateway;

/**
 *
 * @author Kimando Emmanuel
 * @mail kimando@medicmobile.org
 * 
 */
public class MessageReader 
{
    KuvelaControllersInterface controllersInterface = new KuvelaControllersInterface();

    String port = "";
    public MessageReader(String port)
    {
        this.port = port;
    }
    
    public void readMessages() throws Exception
    {
        // Define a list which will hold the read messages.
        List<InboundMessage> msgList;
        // Create the notification callback method for inbound & status report
        // messages.
        InboundNotification inboundNotification = new InboundNotification();
        // Create the notification callback method for inbound voice calls.
        CallNotification callNotification = new CallNotification();
        //Create the notification callback method for gateway statuses.
        GatewayStatusNotification statusNotification = new GatewayStatusNotification();
        OrphanedMessageNotification orphanedMessageNotification = new OrphanedMessageNotification();
        try
        {
            // Create the Gateway representing the serial GSM modem.
            SerialModemGateway gateway = new SerialModemGateway("Kuvela server", port, 9600, "Huawei", "E1750");
            // Set the modem protocol to PDU (alternative is TEXT). PDU is the default, anyway...
            gateway.setProtocol(Protocols.PDU);
            // Do we want the Gateway to be used for Inbound messages?
            gateway.setInbound(true);
            // Do we want the Gateway to be used for Outbound messages?
            gateway.setOutbound(true);
            // Let SMSLib know which is the SIM PIN.
            gateway.setSimPin("5943");
            // Set up the notification methods.
            Service.getInstance().setInboundMessageNotification(inboundNotification);
            Service.getInstance().setCallNotification(callNotification);
            Service.getInstance().setGatewayStatusNotification(statusNotification);
            Service.getInstance().setOrphanedMessageNotification(orphanedMessageNotification);
            // Add the Gateway to the Service object.
            Service.getInstance().addGateway(gateway);
            // Similarly, you may define as many Gateway objects, representing
            // various GSM modems, add them in the Service object and control all of them.
            // Start! (i.e. connect to all defined Gateways)
            Service.getInstance().startService();

            // In case you work with encrypted messages, its a good time to declare your keys.
            // Create a new AES Key with a known key value. 
            // Register it in KeyManager in order to keep it active. SMSLib will then automatically
            // encrypt / decrypt all messages send to / received from this number.
            Service.getInstance().getKeyManager().registerKey("+254729111366", new AESKey(new SecretKeySpec("0011223344556677".getBytes(), "AES")));

            // Sleep now. Emulate real world situation and give a chance to the notifications
            // methods to be called in the event of message or voice call reception.            

            System.in.read();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        } finally
        {
            Service.getInstance().stopService();
        }

    }

    public class InboundNotification implements IInboundMessageNotification
    {

        @Override
        public void process(AGateway gateway, MessageTypes msgType, InboundMessage msg)
        {
            if (msgType == MessageTypes.INBOUND)
            {
                System.out.println(">>> New Inbound message detected from Gateway: " + gateway.getGatewayId());				
                System.out.println(""+msg.toString());
                //System.out.println("Encoding: " + (msg.getEncoding() == MessageEncodings.ENC7BIT ? "7-bit" : (msg.getEncoding() == MessageEncodings.ENC8BIT ? "8-bit" : "UCS2 (Unicode)")));
                System.out.println("Extracting...");
                extractData(msg);                
            } 
            else if (msgType == MessageTypes.STATUSREPORT)
            {
                System.out.println(">>> New Inbound Status Report message detected from Gateway: " + gateway.getGatewayId());
            }
        }
    }

    public class CallNotification implements ICallNotification
    {
        @Override
        public void process(AGateway gateway, String callerId)
        {
            System.out.println(">>> New call detected from Gateway: " + gateway.getGatewayId() + " : " + callerId);
        }
    }

    public class GatewayStatusNotification implements IGatewayStatusNotification
    {
        @Override
        public void process(AGateway gateway, GatewayStatuses oldStatus, GatewayStatuses newStatus)
        {
            System.out.println(">>> Gateway Status change for " + gateway.getGatewayId() + ", OLD: " + oldStatus + " -> NEW: " + newStatus);
        }
    }

    public class OrphanedMessageNotification implements IOrphanedMessageNotification
    {
        @Override
        public boolean process(AGateway gateway, InboundMessage msg)
        {
            System.out.println(">>> Orphaned message part detected from " + gateway.getGatewayId());
            System.out.println(msg);
            // Since we are just testing, return FALSE and keep the orphaned message part.
            return false;
        }
    }

    public void extractData(InboundMessage msg)
    {
        System.out.println("Getting the message details...");
        String gatewayID = msg.getGatewayId();
        String messageType = msg.getClass().getSimpleName();
        String messageUID = msg.getUuid();
        String messageEncoding = (msg.getEncoding() == MessageEncodings.ENC7BIT ? "7-bit" : (msg.getEncoding() == MessageEncodings.ENC8BIT ? "8-bit" : "UCS2 (Unicode)"));
        Date submissionDate = new Date();
        String smscDispatcher = msg.getSmscNumber();
        String sender = "+" + msg.getOriginator();

        String str = "";
        String pduData = "";

        if (msg instanceof InboundBinaryMessage)
        {
            InboundBinaryMessage binaryMessage = (InboundBinaryMessage) msg;
            if (binaryMessage.getDataBytes() != null)
            {
                final Charset UTF_8 = Charset.forName("UTF-8");
                str += new String((binaryMessage).getDataBytes(), UTF_8);
            } else
            {
                str += "CANTPROCESS";
            }
            if (msg instanceof InboundEncryptedMessage)
            {
                try
                {
                    InboundEncryptedMessage encryptedMessage = (InboundEncryptedMessage) msg;
                    str += encryptedMessage.getDecryptedText();
                } catch (Exception e)
                {
                    str += "CANTPROCESS";
                }
            }
        } else
        {
            str += msg.getText();
            try
            {
                pduData = msg.getPduUserData();
            } catch (Exception e)
            {
                pduData = " PDU data: <cannot extract properly, udh present>";
            }
        }
        
        System.out.println("Got message details now...");
        
        if(!str.equals("CANTPROCESS"))
        {
            // Data points are # seperated
            // Checking for at least 5 occurences of # in the returned string avoiding processing other messages that are not originatig from Kuvela STK app
            if(countOccurrences(str, '#') > 5) 
            {
                System.out.println("Spliting...");

                Pattern p = Pattern.compile("#");
                String[] items = p.split(str);

                // The village_clinic_monthly_report has 21 data points
                if(items.length == 21) 
                {
                    System.out.println("Updating the vcmr");
                    controllersInterface.updateVillageClinicMonthlyReport(items, sender, submissionDate);
                    System.out.println("vcmr updated");
                    deleteProcessedMessage(msg);
                }
                
                // The facility_stock has 16 data points
                if(items.length == 15) 
                {
                    System.out.println("Updating the facility stock");
                    controllersInterface.updateFacilityStock(items, sender, submissionDate);
                    System.out.println("facility stock updated");
                    deleteProcessedMessage(msg);
                }
            }
                        
            else if(str.equals("REDEEMAIRTIME"))
            {                
                try
                {
                    System.out.println("Redeem airtime");
                    String message = controllersInterface.redeemPoints(sender);
                    
                    if(message.indexOf('#') > 0)
                    {
                        System.out.println("Send this USSD request: "+message);
                        Service.getInstance().sendUSSDRequest(new USSDRequest(message), gatewayID);
                    }
                    
                    System.out.println("Can't redeem, so send this message: "+message);
                    Service.getInstance().sendMessage(new OutboundMessage(sender, message));
                    System.out.println("Send USSD request: "+Service.getInstance().sendUSSDRequest(new USSDRequest("*130*0727623439#"), gatewayID));
                    deleteProcessedMessage(msg);
                }
                catch(Exception e){}
            }
            
            else
            {
                System.out.println("NOT KUVELA MESSAGE: IGNORE");
            }
        }        
    }

    public int countOccurrences(String haystack, char needle) 
    {   
        int count = 0;
        for (int i = 0; i < haystack.length(); i++)     
        {         
            if (haystack.charAt(i) == needle)         
            {              
                count++;         
            }     
        }     
        return count; 
    }
    
    private void deleteProcessedMessage(InboundMessage msg)
    {
        try
        {
            Service.getInstance().deleteMessage(msg);
            System.out.println("Deleted the processed message..");
        }
        catch(Exception ex){}
    }
    
    public static void main(String[] args)
    {
        try
        {
            MessageReader reader = new MessageReader("COM3");
            reader.readMessages();
            
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}