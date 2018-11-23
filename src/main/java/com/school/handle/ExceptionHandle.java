package com.school.handle;

import com.school.dataobject.Result;
import com.school.exception.StudentException;
import com.school.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//@ControllerAdvice
public class ExceptionHandle {

//    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
//    public Result handle(Exception e){
//        if(e instanceof StudentException){
//            StudentException studentException = (StudentException) e;
//            return ResultUtil.error(studentException.getCode(), studentException.getMessage());
//            return null;
//        }else {
//            return ResultUtil.error(-1,e.getMessage());
//            return null;
//        }
//    }
}
