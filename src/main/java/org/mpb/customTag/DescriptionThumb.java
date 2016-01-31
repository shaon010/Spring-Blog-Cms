package org.mpb.customTag;

/**
 * Created by Shaon on 12/18/2015.
 */

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DescriptionThumb extends SimpleTagSupport {

    private String description;

    public DescriptionThumb() {
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public void doTag() throws JspException, IOException {
        System.out.println("Format is:" + description);
        try {
            String croppedDescription = description;
            if (description != null && description.length() > 50)
                croppedDescription = description.substring(0, 50) + " ...";
            getJspContext().getOut().write(croppedDescription);
        } catch (Exception e) {
            e.printStackTrace();
            // stop page from loading further by throwing SkipPageException
            throw new SkipPageException("Exception in cropping "
                    + " with description " + description);
        }
    }

}
