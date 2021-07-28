import { PolymerElement, html } from '@polymer/polymer/polymer-element.js';
import { ThemableMixin } from '@vaadin/vaadin-themable-mixin/vaadin-themable-mixin.js';

/**
 * `bubble-dialog`
 * A BubbleDialog element
 *
 * @customElement
 * @polymer
 */
class WindowControl extends ThemableMixin(PolymerElement) {
    static get template() {
        return html `
        <style>
        </style> 
        
        <div id="windowcontrol" class="width=0px height=0px">
            
        </div>
        `;
    }

    static get is() {
        return 'window-control';
    }

    static get properties() {
        return {
            targetid: {
                type: String,
                value: ''
            }
        };
    }

    openWindow(targetURL) {
        //console.log("***************************************");
        //console.log(this);
        //var targetid = this.getProperty("targetid");

        // 
        console.log("Opening ", targetURL, "...");
        this.targetWindow = window.open("", "_blank");
        this.targetWindow.document.write("B");
        new_window.close();
    }

    closeWindow() {
        if (this.targetWindow) {
            this.targetWindow.close();
        }
    }


};

customElements.define(WindowControl.is, WindowControl);