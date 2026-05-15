<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">

        <html>

            <head>

                <meta charset="UTF-8"/>

                <title>Столовые приборы</title>

                <style>

                    table {
                        border-collapse: collapse;
                        width: 100%;
                    }

                    th, td {
                        border: 1px solid black;
                        padding: 8px;
                        text-align: center;
                    }

                    th {
                        background-color: lightgray;
                    }

                </style>

            </head>

            <body>

                <h2>Столовые приборы</h2>

                <table>

                    <tr>

                        <th>Тип</th>
                        <th>Страна</th>
                        <th>Длина</th>
                        <th>Ширина</th>
                        <th>Материал</th>
                        <th>Тип рукояти</th>
                        <th>Рукоять</th>
                        <th>Коллекционный</th>

                    </tr>

                    <!-- Сортировка по длине -->
                    <xsl:for-each select="FlatWare/Item">

                        <xsl:sort select="Visual/Length"
                                  data-type="number"/>

                        <tr>

                            <td>
                                <xsl:value-of select="Type"/>
                            </td>

                            <td>
                                <xsl:value-of select="Origin"/>
                            </td>

                            <td>
                                <xsl:value-of select="Visual/Length"/>
                                см
                            </td>

                            <td>
                                <xsl:value-of select="Visual/Width"/>
                                мм
                            </td>

                            <td>
                                <xsl:value-of select="Visual/Material"/>
                            </td>

                            <td>
                                <xsl:value-of select="Visual/Handle/@type"/>
                            </td>

                            <td>
                                <xsl:value-of select="Visual/Handle"/>
                            </td>

                            <td>

                                <xsl:choose>

                                    <xsl:when test="Value='true'">
                                        Да
                                    </xsl:when>

                                    <xsl:otherwise>
                                        Нет
                                    </xsl:otherwise>

                                </xsl:choose>

                            </td>

                        </tr>

                    </xsl:for-each>

                </table>

            </body>

        </html>

    </xsl:template>

</xsl:stylesheet>