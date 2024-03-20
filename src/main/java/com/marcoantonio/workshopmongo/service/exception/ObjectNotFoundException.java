package com.marcoantonio.workshopmongo.service.exception;

import java.io.Serial;

public class ObjectNotFoundException extends RuntimeException{
   private static final long serialVersionUID = 1L;

   public ObjectNotFoundException(String msg){
       super(msg);
   }
}
