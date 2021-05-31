package com.howtodoinjava.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import brave.Span;
import brave.Tracer;

/***
 *  This service shall give the current TraceId.
 *  The traceId can be used for debugging purpose and is capable of distributed logging within spring/boot applications.
 *
 *  Usage:
 *  @Autowired
 *  private TracerService tracerService;
 *
 *  function(HttpServletResponse response){
 *      ....
 *      response.setHeader("omega-trace-id", tracerService.getTraceId());
 *      ....
 *
 *  }
*/

@Service
public class TracerService {

    @Autowired
    private Tracer tracer;

    public String getTraceId() {
        final Span currentSpan = tracer.currentSpan();
        if (currentSpan != null) {
            return currentSpan.context().toString();
        }
        return tracer.nextSpan().context().toString();

    }
}
