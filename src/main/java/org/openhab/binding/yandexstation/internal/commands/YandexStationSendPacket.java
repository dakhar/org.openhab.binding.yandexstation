/**
 * Copyright (c) 2010-2022 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.yandexstation.internal.commands;

import java.util.Date;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

/**
 * The {@link YandexStationSendPacket} is responsible for YandexStationCommandTypes action, which are
 * sent to one of the channels.
 *
 * @author "Dmintry P (d51x)" - Initial contribution
 */
public class YandexStationSendPacket {

    private String conversationToken;
    private String id;
    private Object payload;
    private long sentTime;

    /**
     * Instantiates a new Yandex station send packet.
     *
     * @param conversationToken the conversation token
     * @param command           the command
     */
    public YandexStationSendPacket(String conversationToken, YandexStationCommand command) {
        this.conversationToken = conversationToken;
        this.id = UUID.randomUUID().toString();
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String payload = gson.toJson(command);
        this.payload = JsonParser.parseString(payload).getAsJsonObject();
        this.sentTime = new Date().getTime();
    }

    /**
     * Sets conversation token.
     *
     * @param conversationToken the conversation token
     */
    public void setConversationToken(String conversationToken) {
        this.conversationToken = conversationToken;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets payload.
     *
     * @param payload the payload
     */
    public void setPayload(String payload) {
        this.payload = payload;
    }

    /**
     * Sets sent time.
     *
     * @param sentTime the sent time
     */
    public void setSentTime(long sentTime) {
        this.sentTime = sentTime;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
