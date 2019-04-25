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

package com.dasbikash.news_server_data.data_sources

import com.dasbikash.news_server_data.data_sources.data_services.news_data_services.spring_mvc.NewsDataServiceUtils
import com.dasbikash.news_server_data.models.room_entity.Article
import com.dasbikash.news_server_data.models.room_entity.Page

internal interface NewsDataService {

    companion object {
        const val DEFAULT_ARTICLE_REQUEST_SIZE = 5
    }

    //Latest articles from any page
    fun getRawLatestArticlesByPage(page: Page,
                                   articleRequestSize:Int = DEFAULT_ARTICLE_REQUEST_SIZE):List<Article>

    //Articles after last article ID
    fun getRawArticlesAfterLastId(page: Page, lastArticleId:String,
                                  articleRequestSize:Int = DEFAULT_ARTICLE_REQUEST_SIZE):List<Article>



    fun getLatestArticlesByPage(page: Page,
                                articleRequestSize:Int = DEFAULT_ARTICLE_REQUEST_SIZE):List<Article>{
        val articleList = getRawLatestArticlesByPage(page,articleRequestSize)
        if (articleList.size >0){
            articleList.asSequence().forEach { NewsDataServiceUtils.processFetchedArticleData(it, page) }
        }
        return articleList
    }

    fun getArticlesAfterLastId(page: Page, lastArticleId:String,
                                  articleRequestSize:Int = DEFAULT_ARTICLE_REQUEST_SIZE):List<Article>{

        val articleList = getRawArticlesAfterLastId(page,lastArticleId,articleRequestSize)
        if (articleList.size >0){
            articleList.asSequence().forEach { NewsDataServiceUtils.processFetchedArticleData(it, page) }
        }
        return articleList
    }

}