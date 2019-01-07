package com.rnett.kframejs.bootstrap.content

import com.rnett.kframejs.dom.classes.ListElement
import com.rnett.kframejs.structure.addons.addClass
import com.rnett.kframejs.structure.element.StandardDisplayElement
import org.w3c.dom.HTMLLIElement

fun ListElement<*>.unstyled() = addClass("list-unstyled")
fun ListElement<*>.inline() = addClass("list-inline")
fun StandardDisplayElement<HTMLLIElement>.inlineItem() = addClass("list-inline-item")