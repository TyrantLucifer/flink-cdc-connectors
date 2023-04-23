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
import org.apache.flink.configuration.ConfigOptions;
import org.apache.flink.configuration.Configuration;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/** Tests for {@link OptionUtils}. */
public class OptionUtilsTest {

    @Test
    public void testOptionsPrint() {
        Map<String, String> options = new HashMap<>();
        options.put("host", "localhost:3306");
        options.put("user", "tyrantlucifer");
        options.put("password", "tyrantlucifer");
        Configuration configuration = Configuration.fromMap(options);
        ConfigOption<String> host = ConfigOptions.key("host").stringType().noDefaultValue();
        ConfigOption<String> user = ConfigOptions.key("user").stringType().noDefaultValue();
        ConfigOption<String> password = ConfigOptions.key("password").stringType().noDefaultValue();
        OptionUtils.printOptions(configuration, host, user, password);
    }
}
