<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">

        <html>
            <body>

                <h2>Столовые приборы</h2>

                <table border="1">

                    <tr>
                        <th>Тип</th>
                        <th>Страна</th>
                        <th>Длина</th>
                        <th>Ширина</th>
                        <th>Материал</th>
                        <th>Рукоять</th>
                        <th>Коллекционный</th>
                    </tr>

                    <xsl:for-each select="FlatWare/Item">

                        <!-- Сортировка -->
                        <xsl:sort select="Visual/BladeLength | Visual/ToothLength"
                                  data-type="number"/>

                        <tr>

                            <td>
                                <xsl:value-of select="Type"/>
                            </td>

                            <td>
                                <xsl:value-of select="Origin"/>
                            </td>

                            <td>
                                <xsl:value-of select="Visual/BladeLength"/>
                                <xsl:value-of select="Visual/ToothLength"/>
                            </td>

                            <td>
                                <xsl:value-of select="Visual/BladeWidth"/>
                            </td>

                            <td>
                                <xsl:value-of select="Visual/Material"/>
                            </td>

                            <td>
                                <xsl:value-of select="Visual/Handle"/>
                            </td>

                            <td>
                                <xsl:value-of select="Value"/>
                            </td>

                        </tr>

                    </xsl:for-each>

                </table>

            </body>
        </html>

    </xsl:template>

</xsl:stylesheet>