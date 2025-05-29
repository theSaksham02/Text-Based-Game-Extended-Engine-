//package org.uob.a2.gameobjects;

public class UseInformation {
    private boolean success;
    private String action;
    private String target;
    private String result;
    private String message;
    private String targetId;
    private String sourceId;

    // Constructor with all parameters
    public UseInformation(boolean success, String action, String target, String result, String message) {
        this.success = success;
        this.action = action;
        this.target = target;
        this.result = result;
        this.message = message;
    }

    // Constructor without success parameter
    public UseInformation(String action, String target, String result, String message) {
        this.success = true; // Default to true
        this.action = action;
        this.target = target;
        this.result = result;
        this.message = message;
    }

    // Default constructor
    public UseInformation() {
        this.success = false;
        this.action = "";
        this.target = "";
        this.result = "";
        this.message = "";
    }

    // Getters and Setters
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // Add these methods
    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public boolean isUsed() {
        return success;
    }

    public void setUsed(boolean used) {
        this.success = used;
    }

    @Override
    public String toString() {
        return String.format("UseInformation{isUsed=%b, action='%s', target='%s', result='%s', message='%s'}",
            success, action, target, result, message);
    }
}