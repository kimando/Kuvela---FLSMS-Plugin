package org.medicmobile.projects.desktop.kuvela.controllers.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kimando Emmanuel
 * @mail kimando@medicmobile.org
 * 
 */

public class IllegalOrphanException extends Exception {
    private List<String> messages;
    public IllegalOrphanException(List<String> messages) {
        super((messages != null && messages.size() > 0 ? messages.get(0) : null));
        if (messages == null) {
            this.messages = new ArrayList<String>();
        }
        else {
            this.messages = messages;
        }
    }
    public List<String> getMessages() {
        return messages;
    }
}
