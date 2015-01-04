/*
 * Copyright (c) 2012-2014 Spotify AB
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.spotify.netty4.handler.codec.zmtp;

import io.netty.buffer.ByteBuf;

public class ZMTPWriter {

  private final int version;
  private final ByteBuf buf;

  public ZMTPWriter(final int version, final ByteBuf buf) {
    this.version = version;
    this.buf = buf;
  }

  public ByteBuf frame(final int size, final boolean more) {
    ZMTPUtils.writeFrameHeader(buf, size, more, version);
    return buf;
  }
}