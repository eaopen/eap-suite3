package org.openea.eap.module.member.api.config;

import org.openea.eap.module.member.api.config.dto.MemberConfigRespDTO;
import org.openea.eap.module.member.convert.config.MemberConfigConvert;
import org.openea.eap.module.member.service.config.MemberConfigService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * 用户配置 API 实现类
 *
 * @author owen
 */
@Service
@Validated
public class MemberConfigApiImpl implements MemberConfigApi {

    @Resource
    private MemberConfigService memberConfigService;

    @Override
    public MemberConfigRespDTO getConfig() {
        return MemberConfigConvert.INSTANCE.convert01(memberConfigService.getConfig());
    }

}
