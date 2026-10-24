package com.learn.tlias.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

/**
 * 员工操作日志
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpLog {
    private Integer id; //ID
    private LocalDateTime operateTime; //操作时间
    private String info; //详细信息
}
