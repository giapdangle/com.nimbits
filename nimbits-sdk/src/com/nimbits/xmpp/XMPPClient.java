/*
 * Copyright (c) 2010 Tonic Solutions LLC.
 *
 * http://www.nimbits.com
 *
 *
 * Licensed under the GNU GENERAL PUBLIC LICENSE, Version 3.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.gnu.org/licenses/gpl.html
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the license is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, eitherexpress or implied. See the License for the specific language governing permissions and limitations under the License.
 */

package com.nimbits.xmpp;

import com.nimbits.client.exception.NimbitsException;
import com.nimbits.client.model.point.PointName;
import com.nimbits.client.model.value.Value;

/**
 * Created by Benjamin Sautner
 * User: BSautner
 * Date: 11/22/11
 * Time: 3:56 PM
 */
public interface XMPPClient {
    boolean connect() throws NimbitsException;

    void sendMessage(final String outgoingMessage);

    void sendValue(PointName pointName, Value value);

    void addMessageReceivedListeners(final XMPPClientImpl.MessageReceivedListener listener);

    void disconnect();
}
