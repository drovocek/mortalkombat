package edu.volkov.mortalkombat.to;

import edu.volkov.mortalkombat.model.FinishType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FinishingOffTo  extends BaseTo<Integer>  {

    private FinishType finishType;

    private int showy;

    private int complexity;

    public FinishingOffTo(Integer id) {
        super(id);
    }
}
