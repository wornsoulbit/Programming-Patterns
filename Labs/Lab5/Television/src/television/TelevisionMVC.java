
package television;

/**
 * Television with MVC.
 * 
 * @author Alex Vasil
 */
public class TelevisionMVC {
    private String manufacturer;
    private int screenSize;
    private boolean powerOn;
    private int channel;
    private int volume;
    
    /**
     * Sets the channel.
     * 
     * @param channel Channel the TV is on.
     */
    public void setChannel(int channel) {
        this.channel = channel;
    }
    
    /**
     * Cycles the power to on if off and off if on.
     */
    public void power() {
        if (powerOn) {
            powerOn = false;
        } else {
            powerOn = true;
        }
    }
    
    /**
     * Increases the volume of the TV to a max of 100.
     */
    public void increaseVolume() {
        if (volume != 100) {
            volume++;
        }
    }
    
    /**
     * Decreases the volume of the TV to a minimum of 0.
     */
    public void decreaseVolume() {
        if (volume != 0) {
            volume--;
        }
    }
    
    /**
     * Gets the current channel.
     * 
     * @return Current channel.
     */
    public int getChannel() {
        return channel;
    }
    
    /**
     * Gets the current volume.
     * 
     * @return Current volume.
     */
    public int getVolume() {
        return volume;
    }
    
    /**
     * Gets the manufacturer of the TV.
     * 
     * @return Manufacturer.
     */
    public String getManufacturer() {
        return manufacturer;
    }
    
    /**
     * Gets the screen size.
     * 
     * @return Screen size.
     */
    public int getScreenSize() {
        return screenSize;
    }
}
