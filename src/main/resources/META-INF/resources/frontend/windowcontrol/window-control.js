import { PolymerElement, html } from '@polymer/polymer/polymer-element.js';
import { ThemableMixin } from '@vaadin/vaadin-themable-mixin/vaadin-themable-mixin.js';

/**
 * 
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
        console.log("\n\n\n\nOpening ", targetURL, "...");
        this.targetWindow = window.open(targetURL, "_blank");

        this.$server.callback();
    }

    closeWindow() {
        if (this.targetWindow) {
            this.targetWindow.close();
            this.$server.callback();
        }
    }

};

customElements.define(WindowControl.is, WindowControl);