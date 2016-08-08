/*
 * The MIT License
 *
 * Copyright (c) 2016 CloudBees, Inc
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

package com.cloudbees.jenkins.plugins.filter;

import com.cloudbees.jenkins.plugins.cause.BitbucketTriggerCause;
import com.cloudbees.jenkins.plugins.payload.BitbucketPayload;
import hudson.model.AbstractDescribableImpl;

import java.io.File;
import java.io.IOException;

/**
 * The base {@link AbstractDescribableImpl} class for {@link BitbucketTriggerFilter} implementations
 * @since August 1, 2016
 * @version 2.0
 */
public abstract class BitbucketTriggerFilter extends AbstractDescribableImpl<BitbucketTriggerFilter> {
    /**
     * Returns {@code true} if a build should be triggered based on the payload received by Bitbucket
     *
     * @return {@code true} if a build should be triggered based on the payload received by Bitbucket
     */
    public abstract boolean shouldScheduleJob(BitbucketPayload bitbucketPayload);

    /**
     * Gets the cause of the trigger
     *
     * @return the {@link BitbucketTriggerCause}
     */
    public abstract BitbucketTriggerCause getCause(File pollingLog, BitbucketPayload pullRequestPayload) throws IOException;

    /**
     * Gets the {@link AbstractDescribableImpl} of the ActionFilter
     *
     * @return the {@link AbstractDescribableImpl}
     */
    public abstract AbstractDescribableImpl getActionFilter();
}
