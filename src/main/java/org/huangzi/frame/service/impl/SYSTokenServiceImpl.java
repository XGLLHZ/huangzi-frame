package org.huangzi.frame.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.huangzi.frame.entity.SYSToken;
import org.huangzi.frame.mapper.SYSTokenMapper;
import org.huangzi.frame.service.SYSTokenService;
import org.huangzi.frame.util.TokenUtil;
import org.springframework.stereotype.Service;

/**
 * @author: XGLLHZ
 * @date: 2019/9/6 10:34
 * @description: token事务层-实现类
 */
@Service
public class SYSTokenServiceImpl extends ServiceImpl<SYSTokenMapper, SYSToken> implements SYSTokenService {

    @Override
    public String createToken(int userId) {
        return TokenUtil.createJWS(String.valueOf(userId));
    }

    @Override
    public Integer checkToken(String token) {
        return TokenUtil.checkJWS(token);
    }

}
