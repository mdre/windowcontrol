package com.awesomecontrols.windowcontrol;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.ClassList;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.Style;

@Tag("window-control")
// @StyleSheet("frontend://bower_components/bubbledialog/cards.css")
@JsModule("./windowcontrol/window-control.js")
public class WindowControl extends Component implements HasStyle {

    /**
     *
     */
    private static final long serialVersionUID = 5630472247035116755L;

    private final static Logger LOGGER = Logger.getLogger(WindowControl.class.getName());
    static {
        if (LOGGER.getLevel() == null) {
            LOGGER.setLevel(Level.FINER);
        }
    }
    @Id("windowcontrol")
    Div wc;

    // determina el estado actual. True si hay una dirección abierta, false si se ha cerrado.
    boolean state = false;
    /**
     * Create a bubbleContent near to the target component
     * 
     * @param target  is the ID of the target component
     * @param content the bubbleContent content.
     */
    public WindowControl() {
    }

    /**
     * Show the bubbleContent
     */
    public void openWindow(String targetURL) {
        LOGGER.log(Level.FINER, "llamando a openWindow...");
        LOGGER.log(Level.FINER, "targetId: " + targetURL);
        getElement().callJsFunction("openWindow", targetURL);
        this.state = true;
    }

    @ClientCallable
    private void callback(){
        LOGGER.log(Level.FINEST,"callback!!" );
    }

    /**
     * Hide the bubbleContent
     */
    public void closeWindow() {
        LOGGER.log(Level.FINER, "close window");
        getElement().callJsFunction("closeWindow");
        this.state = false;
    }

    public boolean getState() {
        return this.state;
    }
}
