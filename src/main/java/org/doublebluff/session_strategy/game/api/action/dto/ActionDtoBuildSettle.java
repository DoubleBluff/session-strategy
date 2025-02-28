package org.doublebluff.session_strategy.game.api.action.dto;

import lombok.Data;
import org.doublebluff.session_strategy.game.map.SettleCoordinatesDto;

@Data
public class ActionDtoBuildSettle extends ActionDto {

    private SettleCoordinatesDto settleCoordinatesDto;
}
