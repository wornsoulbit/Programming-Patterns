
package television;

/**
 * Television controller.
 * 
 * @author Alex Vasil
 */
public class TelevisionController {
    TelevisionView view;
    TelevisionMVC model;

    /**
     * Constructor for a television controller.
     * 
     * @param view View of the television.
     * @param model Television.
     */
    public TelevisionController(TelevisionView view, TelevisionMVC model) {
        this.view = view;
        this.model = model;
    }
    
    /**
     * Updates the model's view.
     */
    public void updateView() {
        view.printTelevisionView(model.getManufacturer(), model.getScreenSize(), model.getChannel(), model.getVolume());
    }
    
    /**
     * Sets the channel.
     * 
     * @param channel Channel the TV is on.
     */
    public void setChannel(int channel) {
        model.setChannel(channel);
    }
    
    /**
     * Cycles the power to on if off and off if on.
     */
    public void power() {
        model.power();
    }
    
    /**
     * Increases the volume of the TV to a max of 100.
     */
    public void increaseVolume() {
        model.increaseVolume();
    }
    
    /**
     * Decreases the volume of the TV to a minimum of 0.
     */
    public void decreaseVolume() {
        model.decreaseVolume();
    }
    
    /**
     * Gets the current channel.
     * 
     * @return Current channel.
     */
    public int getChannel() {
        return model.getChannel();
    }
    
    /**
     * Gets the current volume.
     * 
     * @return Current volume.
     */
    public int getVolume() {
        return model.getVolume();
    }
    
    /**
     * Gets the manufacturer of the TV.
     * 
     * @return Manufacturer.
     */
    public String getManufacturer() {
        return model.getManufacturer();
    }
    
    /**
     * Gets the screen size.
     * 
     * @return Screen size.
     */
    public int getScreenSize() {
        return model.getScreenSize();
    }
}
