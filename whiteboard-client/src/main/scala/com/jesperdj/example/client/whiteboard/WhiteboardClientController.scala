/*
 * Copyright 2016 Jesper de Jong
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
package com.jesperdj.example.client.whiteboard

import com.jesperdj.example.client.whiteboard.domain.Note
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.{RequestBody, RequestMapping, RequestMethod, ResponseBody}

@Controller
class WhiteboardClientController @Autowired()(whiteboardClient: WhiteboardClient) {

  @RequestMapping(Array("/"))
  def index(model: Model): String = {
    model.addAttribute("notes", whiteboardClient.getAllNotes)
    "index"
  }

  @RequestMapping(method = Array(RequestMethod.POST), path = Array("/add"), consumes = Array("application/json"))
  @ResponseBody
  def add(@RequestBody note: Note): Note = whiteboardClient.addNote(note)
}
