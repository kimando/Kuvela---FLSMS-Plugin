package org.medicmobile.projects.desktop.kuvela.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2011-09-17T15:08:26")
@StaticMetamodel(PointsManager.class)
public class PointsManager_ { 

    public static volatile SingularAttribute<PointsManager, Integer> amountRedeemedLast;
    public static volatile SingularAttribute<PointsManager, String> phoneNumber;
    public static volatile SingularAttribute<PointsManager, Date> lastRedeemed;
    public static volatile SingularAttribute<PointsManager, Integer> points;
    public static volatile SingularAttribute<PointsManager, Integer> totalCreditRedeemed;

}