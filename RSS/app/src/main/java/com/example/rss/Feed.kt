package com.example.rss

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Path
import org.simpleframework.xml.Root


@Root(name = "rss", strict = false)

data class Feed  @JvmOverloads constructor(


    @field: Element(name = "title")
    @param: Element(name = "title")
    @field: Path("channel")
    @param:Path("channel")
    var channelTitle: String? = null,

    @field: ElementList(name = "item", inline = true, required = false)
    @param: ElementList(name = "item", inline = true, required = false)
    @field:Path("channel")
    @param:Path("channel")
    var articleList: List<Article>? = null



        )