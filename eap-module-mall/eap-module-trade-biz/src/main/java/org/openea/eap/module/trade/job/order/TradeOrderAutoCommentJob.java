package org.openea.eap.module.trade.job.order;

import org.openea.eap.framework.quartz.core.handler.JobHandler;
import org.openea.eap.framework.tenant.core.job.TenantJob;
import org.openea.eap.module.trade.service.order.TradeOrderUpdateService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 交易订单的自动评论 Job
 *
 */
@Component
public class TradeOrderAutoCommentJob implements JobHandler {

    @Resource
    private TradeOrderUpdateService tradeOrderUpdateService;

    @Override
    @TenantJob
    public String execute(String param) {
        int count = tradeOrderUpdateService.createOrderItemCommentBySystem();
        return String.format("评论订单 %s 个", count);
    }

}
