package org.medicmobile.projects.desktop.kuvela.controllers.exceptions;

/**
 *
 * @author Kimando Emmanuel
 * @mail kimando@medicmobile.org
 * 
 */
public class PreexistingEntityException extends Exception {
    public PreexistingEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    public PreexistingEntityException(String message) {
        super(message);
    }
}
