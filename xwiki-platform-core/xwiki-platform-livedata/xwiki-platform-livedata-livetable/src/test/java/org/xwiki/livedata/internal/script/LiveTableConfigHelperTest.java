/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.livedata.internal.script;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.xwiki.test.junit5.mockito.ComponentTest;
import org.xwiki.test.junit5.mockito.InjectMockComponents;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for {@link LiveTableConfigHelper}.
 * 
 * @version $Id$
 * @since 12.9
 */
@ComponentTest
class LiveTableConfigHelperTest
{
    @InjectMockComponents
    private LiveTableConfigHelper configHelper;

    @ParameterizedTest
    @MethodSource("getTestData")
    void getConfigJSON(String input, String output) throws Exception
    {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode liveTableConfig = objectMapper.readTree(input);
        String id = liveTableConfig.path("id").asText();
        List<String> columns = objectMapper.readerForListOf(String.class).readValue(liveTableConfig.path("columns"));
        Map<String, Object> columnProperties =
            objectMapper.readerForMapOf(Object.class).readValue(liveTableConfig.path("columnProperties"));
        Map<String, Object> options =
            objectMapper.readerForMapOf(Object.class).readValue(liveTableConfig.path("options"));
        assertEquals(output, this.configHelper.getConfigJSON(id, columns, columnProperties, options));
    }

    private static Stream<String[]> getTestData() throws Exception
    {
        File inputFolder = new File("src/test/resources/liveTableConfigHelper");
        return Stream.of(inputFolder.listFiles(file -> file.getName().endsWith(".test")))
            .map(LiveTableConfigHelperTest::getTestData);
    }

    private static String[] getTestData(File file)
    {
        try {
            Iterator<String> linesIterator = IOUtils.readLines(new FileReader(file)).iterator();
            String input = readLines(linesIterator);
            String output = readLines(linesIterator);
            return new String[] {input, output};
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String readLines(Iterator<String> linesIterator)
    {
        StringBuilder lines = new StringBuilder();
        while (linesIterator.hasNext()) {
            String line = linesIterator.next();
            if (!line.startsWith("---")) {
                lines.append(line.trim());
            } else {
                break;
            }
        }
        return lines.toString();
    }
}
