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
package io.jenkins.plugins.make_jenkins_slow;

import java.util.Collection;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.QueryParameter;

import hudson.Extension;
import hudson.model.Descriptor;
import hudson.model.Label;
import hudson.slaves.Cloud;
import hudson.slaves.NodeProvisioner;
import hudson.util.FormValidation;

public class SlowCloud extends Cloud {

    private static final Logger log = Logger.getLogger(SlowEscapedMarkupFormatter.class.getName());

    /** amount of time (in seconds) to delay. */
    private int delay = 0;

    /**
     * Constructs a new {@code SlowCloud} with the specified delay.
     * @param delay amount of time (in seconds) to delay.
     */
    @DataBoundConstructor
    @SuppressWarnings("unused") // stapler
    public SlowCloud(int delay) {
        super("Slow non-provisioning cloud");
        this.delay = delay;
    }

    public int getDelay() {
        return delay;
    }

    @SuppressWarnings("unused") // serialisation
    private Object readResolve() {
        if (delay > 0) {
            log.log(Level.WARNING, "Intentionally slowing down for {0} seconds", delay);
            try {
                Thread.sleep(delay * 1000L);
            }
            catch (InterruptedException iex) {
                log.log(Level.WARNING, "interrupted whilst delaying startup", iex);
            }
        }
        return this;
    }

    @Override
    public Collection<NodeProvisioner.PlannedNode> provision(Label label, int i) {
        return Collections.EMPTY_LIST;
    }

    @Override
    public boolean canProvision(Label label) {
        return false;
    }

    @Extension
    public static final class DescriptorImpl extends Descriptor<Cloud> {

        @Override
        public String getDisplayName() {
            return "Slow Cloud";
        }

        public FormValidation doCheckDelay(@QueryParameter String value) {
            try {
                int delay = Integer.parseInt(value);
                if (delay < 0) {
                    return FormValidation.error("Negative delays are not supported");
                }
                if (delay > 300) {
                    return FormValidation.warning("A delay of more than 5 minutes is not recommended");
                }
                return FormValidation.ok();
            } catch (NumberFormatException e) {
                return FormValidation.error("Not a number");
            }
        }
    }
}
