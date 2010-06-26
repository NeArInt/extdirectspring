/**
 * Copyright 2010 Ralph Schaer <ralphschaer@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ch.ralscha.extdirectspring.mock;

import java.io.IOException;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.bean.ExtDirectResponse;
import ch.ralscha.extdirectspring.bean.ExtDirectResponseBuilder;

@Controller
public class FormInfoController {

  @ExtDirectMethod
  @ResponseBody
  @RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
  public ExtDirectResponse updateInfo(Locale locale, HttpServletRequest request, @Valid FormInfo formInfo, BindingResult result) {    
    ExtDirectResponseBuilder builder = new ExtDirectResponseBuilder(request);
    builder.addErrors(locale, result);
    return builder.build();
  }
  
  @ExtDirectMethod
  @RequestMapping(value = "/upload", method = RequestMethod.POST)
  public void upload(Locale locale, HttpServletRequest request, HttpServletResponse response, @Valid FormInfo formInfo, BindingResult result) throws IOException {    
    ExtDirectResponseBuilder builder = new ExtDirectResponseBuilder(request);
    builder.addErrors(locale, result);
    builder.buildAndWriteUploadResponse(response);
  }

}