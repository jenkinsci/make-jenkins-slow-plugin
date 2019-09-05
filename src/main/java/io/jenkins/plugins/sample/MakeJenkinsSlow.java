/*
 * The MIT License
 *
 * Copyright 2019 CloudBees, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package io.jenkins.plugins.sample;

import java.util.logging.Level;
import java.util.logging.Logger;

import hudson.Extension;
import hudson.init.InitMilestone;
import hudson.init.Initializer;

//@Extension
public class MakeJenkinsSlow {

    private static Logger logger = Logger.getLogger(MakeJenkinsSlow.class.getName());

//    plugin is not available here so this is nonsense
//    @Initializer(before=InitMilestone.STARTED)
//    public void stared() throws InterruptedException {
//        snooze(InitMilestone.STARTED);
//    }

//    plugin is not available here so this is nonsense
//    @Initializer(before=InitMilestone.PLUGINS_LISTED, after=InitMilestone.STARTED)
//    public void PLUGINS_LISTED() {
//        snooze(InitMilestone.PLUGINS_LISTED);
//    }


    //    plugin is not available here so this is nonsense
//    @Initializer(before=InitMilestone.PLUGINS_PREPARED , after=InitMilestone.PLUGINS_LISTED)
//    public void PLUGINS_PREPARED() {
//        snooze(InitMilestone.PLUGINS_PREPARED);
//    }

/*
    @Initializer(before=InitMilestone.PLUGINS_STARTED, after=InitMilestone.PLUGINS_PREPARED)
    public void PLUGINS_STARTED() {
        snooze(InitMilestone.PLUGINS_STARTED);
    }

    @Initializer(before=InitMilestone.EXTENSIONS_AUGMENTED, after=InitMilestone.PLUGINS_STARTED)
    public void EXTENSIONS_AUGMENTED() {
        snooze(InitMilestone.EXTENSIONS_AUGMENTED);
    }

    @Initializer(before=InitMilestone.JOB_LOADED, after=InitMilestone.EXTENSIONS_AUGMENTED)
    public void JOB_LOADED() {
        snooze(InitMilestone.JOB_LOADED);
    }

    @Initializer(before=InitMilestone.COMPLETED, after=InitMilestone.JOB_LOADED)
    public void COMPLETED() {
        snooze(InitMilestone.COMPLETED);
    }

    private void snooze(InitMilestone milestone) {
        logger.log(Level.WARNING, "Making Jenkins slow for {0}", milestone.name());
        try {
            Thread.sleep(30_000L);
        } catch (InterruptedException ex) {
            logger.log(Level.WARNING, "could not sleep", ex);
        }
        logger.log(Level.WARNING, "We made Jenkins slow for {0}", milestone.name());
    }

 */
}
