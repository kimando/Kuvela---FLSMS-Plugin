package org.medicmobile.projects.desktop.kuvela.controllers.exceptions;

/**
 *
 * @author Kimando Emmanuel
 * @mail kimando@medicmobile.org
 * 
 */
public class NonexistentEntityException extends Exception {
    public NonexistentEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    public NonexistentEntityException(String message) {
        super(message);
    }
}
