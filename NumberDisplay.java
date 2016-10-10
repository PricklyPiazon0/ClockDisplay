
/**
 * The NumberDisplay class represents a digital number display that can hold
 * values from zero to a given limit. The limit can be specified when creating
 * the display. The values range from zero (inclusive) to limit-1. If used,
 * for example, for the seconds on a digital clock, the limit would be 60, 
 * resulting in display values from 0 to 59. When incremented, the display 
 * automatically rolls over to zero when reaching the limit.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class NumberDisplay
{
    private int limit;
    private int value;
    private boolean isTwelve;

    /**
     * Constructor for objects of class NumberDisplay.
     * Set the limit at which the display rolls over.
     */
    public NumberDisplay(int rollOverLimit)
    {
        limit = rollOverLimit;
        value = 0;
        isTwelve = false;
    }

    /**
     * Constructor for objects of class NumberDisplay.
     * Set the limit at which the display rolls over.
     * and allows for a twelve hour display clock
     */
    public NumberDisplay(int rollOverLimit, boolean twelveHour)
    {
        if (twelveHour == true)
        {
            limit = 12;
            value = 12;
            isTwelve = true;
        }
        else
        {
            limit = rollOverLimit;
            value = 0;
            isTwelve = false;
        }
    }
    
    /**
     * Return the current value.
     */
    public int getValue()
    {
        return value;
    }

    /**
     * Return the display value (that is, the current value as a two-digit
     * String. If the value is less than ten, it will be padded with a leading
     * zero).
     */
    public String getDisplayValue()
    {
        if(value < 10) {
            return "0" + value;
        }
        else {
            return "" + value;
        }
    }

    /**
     * Set the value of the display to the new specified value. If the new
     * value is less than zero or over the limit, do nothing.
     */
    public void setValue(int replacementValue)
    {
        if(replacementValue == 0)
        {
            if(isTwelve == true)
            {
                value = 12;
            }
        }
        else if((replacementValue >= 0) && (replacementValue < limit)) {
            value = replacementValue;
        }
    }

    /**
     * Increment the display value by one, rolling over to zero if the
     * limit is reached.
     */
    public void increment()
    {
        value = (value + 1) % limit;
        if (isTwelve) 
        {
            if(value == 0)
            {
                value = 12;
            }
        }
    }
}
