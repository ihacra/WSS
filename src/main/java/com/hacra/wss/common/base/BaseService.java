package com.hacra.wss.common.base;

import org.springframework.transaction.annotation.Transactional;

/**
 * BaseService
 * 
 * @author Hacra
 * @date 2020/05/13
 */
@Transactional(readOnly = true)
public abstract class BaseService {

}
