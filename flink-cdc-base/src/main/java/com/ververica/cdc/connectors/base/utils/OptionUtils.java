/*
 * Copyright 2022 Ververica Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ververica.cdc.connectors.base.utils;

import org.apache.flink.configuration.ConfigOption;
import org.apache.flink.configuration.ReadableConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/** A utility class to print configuration of connectors. */
public class OptionUtils {

    private static final Logger LOG = LoggerFactory.getLogger(OptionUtils.class);

    private static final List<String> SENSITIVE_OPTIONS = Arrays.asList("password");

    private static final String SHADE = "**********";

    /** Utility class can not be instantiated. */
    private OptionUtils() {}

    public static void printOptions(ReadableConfig config, ConfigOption<?>... options) {
        for (ConfigOption<?> option : options) {
            if (SENSITIVE_OPTIONS.contains(option.key())) {
                LOG.info("{} = {}", option.key(), SHADE);
            } else {
                LOG.info("{} = {}", option.key(), config.get(option));
            }
        }
    }
}
