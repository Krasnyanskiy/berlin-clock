package com.ubs.opsit.interviews;

public interface TimeConverter {

    /**
     * Converts the given time input into the Berlin Clock Time.
     *
     * @param aTime the given time
     * @return Berlin Clock time representation
     */
    String convertTime(String aTime);

}
