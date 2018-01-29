/*
 * Copyright 2018 Pivotal Software, Inc..
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.matecomp.sportlife.utils;

import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang3.time.DateUtils;

/**
 ** La clase FechaUtil es utilizada para la administraci\u00f3n de los m\u00e9todos utilitarios para fechas.
 * @author Diego Tonguino
 */
public class FechaUtil {

    public static Calendar calendar() {
        return Calendar.getInstance();
    }

    public static Calendar calendar(Date fecha) {
        Calendar calendar = calendar();
        calendar.setTime(fecha);
        return calendar;
    }

    public static Date truncate(Date fecha) {
        return DateUtils.truncate(fecha, Calendar.DAY_OF_MONTH);
    }

    public static Date hoy() {
        return truncate(calendar().getTime());
    }

    public static Date ahora() {
        return calendar().getTime();
    }

}
