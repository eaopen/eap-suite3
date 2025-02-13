package org.openea.eap.module.pay.convert.wallet;

import org.openea.eap.framework.common.pojo.PageResult;
import org.openea.eap.framework.common.util.collection.MapUtils;
import org.openea.eap.module.member.api.user.dto.MemberUserRespDTO;
import org.openea.eap.module.pay.controller.admin.wallet.vo.wallet.PayWalletRespVO;
import org.openea.eap.module.pay.controller.app.wallet.vo.wallet.AppPayWalletRespVO;
import org.openea.eap.module.pay.dal.dataobject.wallet.PayWalletDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Map;

@Mapper
public interface PayWalletConvert {

    PayWalletConvert INSTANCE = Mappers.getMapper(PayWalletConvert.class);

    AppPayWalletRespVO convert(PayWalletDO bean);

    PayWalletRespVO convert02(String nickname,String avatar, PayWalletDO bean);

    PageResult<PayWalletRespVO> convertPage(PageResult<PayWalletDO> page);

    default PageResult<PayWalletRespVO> convertPage(PageResult<PayWalletDO> page, Map<Long, MemberUserRespDTO> userMap) {
        PageResult<PayWalletRespVO> pageResult = convertPage(page);
        pageResult.getList().forEach(wallet -> MapUtils.findAndThen(userMap, wallet.getUserId(),
                user -> wallet.setNickname(user.getNickname()).setAvatar(user.getAvatar())));
        return pageResult;
    }

}
