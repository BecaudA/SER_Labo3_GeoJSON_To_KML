package ch.heigvd.ser.labo3;

import org.jdom2.Element;

public interface FormattableToKML {
    /**
     * Get an element corresponding to the instance of the caller.
     * @return instance of Element.
     */
    Element toKML();
}
