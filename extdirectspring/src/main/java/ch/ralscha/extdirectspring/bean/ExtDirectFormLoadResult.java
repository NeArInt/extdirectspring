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

package ch.ralscha.extdirectspring.bean;

/**
 * Class representing the result of a form load request
 * 
 * @author mansari
 * @author Ralph Schaer
 */
public class ExtDirectFormLoadResult {

  private Object data;
  private boolean success;

  public ExtDirectFormLoadResult() {
    this(null, true);
  }

  public ExtDirectFormLoadResult(final Object data) {
    this(data, true);
  }

  public ExtDirectFormLoadResult(final Object data, final boolean success) {
    this.data = data;
    this.success = success;
  }

  public Object getData() {
    return data;
  }

  public void setData(final Object data) {
    this.data = data;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(final boolean success) {
    this.success = success;
  }

  @Override
  public String toString() {
    return "ExtDirectFormResultWrapper [data=" + data + ", success=" + success + "]";
  }

}
