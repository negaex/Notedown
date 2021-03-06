package com.example.notes;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Test;



public class MarkupTest extends ApplicationTestCase<Application> {

    public MarkupTest() {
        super(Application.class);
    }

    @Test
    public void testBold() {
        String testString = "**This is bold**, **this isn't.";

        // Render
        String newString = MarkupRenderer.render(testString);
        String expectedString = "<strong>This is bold</strong>, **this isn't.";
        assertEquals(newString, expectedString);

        // Edit
        String newString2 = MarkupRenderer.editor(testString);
        String expectedString2 = "<strong><font color='#00ADC4'>&#42&#42This is bold&#42&#42</font></strong>, **this isn't.";
        assertEquals(newString2, expectedString2);

        // Preview
        String newString3 = MarkupRenderer.preview(testString);
        String expectedString3 = "<strong>This is bold</strong>, **this isn't.";
        assertEquals(newString3, expectedString3);
    }

    @Test
    public void testItalic() {
        String testString = "*This is italics*, **this isn't.";

        // Render
        String newString = MarkupRenderer.render(testString);
        String expectedString = "<i>This is italics</i>, **this isn't.";
        assertEquals(newString, expectedString);

        // Edit
        String newString2 = MarkupRenderer.editor(testString);
        String expectedString2 = "<i><font color='#CF8353'>*This is italics*</font></i>, **this isn't.";
        assertEquals(newString2, expectedString2);

        // Preview
        String newString3 = MarkupRenderer.preview(testString);
        String expectedString3 = "<i>This is italics</i>, **this isn't.";
        assertEquals(newString3, expectedString3);
    }

    @Test
    public void testTitle() {
        String testString = "# Title";

        // Render
        String newString = MarkupRenderer.render(testString);
        String expectedString = "<big><big><big><big><b> Title</b></big></big></big></big>";
        assertEquals(newString, expectedString);

        // Edit
        String newString2 = MarkupRenderer.editor(testString);
        String expectedString2 = "<b><big><big><big><font color='#7A6AAE'># Title</font></big></big></big></b>";
        assertEquals(newString2, expectedString2);

        // Preview
        String newString3 = MarkupRenderer.preview(testString);
        String expectedString3 = "<b> Title</b>";
        assertEquals(newString3, expectedString3);
    }

    @Test
    public void testImage() {
        String testString = "![desc](link)";

        // Render
        String newString = MarkupRenderer.render(testString);
        String expectedString = "<img src=\"link\" />";
        assertEquals(newString, expectedString);

        // Edit
        String newString2 = MarkupRenderer.editor(testString);
        String expectedString2 = "<font color='#7DC962'>![<strong>desc</strong>](link)</font>";
        assertEquals(newString2, expectedString2);

        // Preview
        String newString3 = MarkupRenderer.preview(testString);
        String expectedString3 = "![desc](link)";
        assertEquals(newString3, expectedString3);
    }
}