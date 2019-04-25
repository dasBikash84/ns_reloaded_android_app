/*
 * Copyright 2019 das.bikash.dev@gmail.com. All rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dasbikash.news_server_data.repositories

import android.content.Context
import com.dasbikash.news_server_data.repositories.repo_helpers.DbImplementation

object RepositoryFactory {

    private val dbImplementation = DbImplementation.ROOM

    fun getUserSettingsRepository(context: Context):
            UserSettingsRepository = UserSettingsRepository.getImpl(context, dbImplementation)

    fun getAppSettingsRepository(context: Context):
            AppSettingsRepository = AppSettingsRepository.getImpl(context, dbImplementation)

    fun getNewsDataRepository(context: Context):
            NewsDataRepository = NewsDataRepository.getImpl(context, dbImplementation)

}