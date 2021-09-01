package edu.volkov.mortalkombat.to;

import edu.volkov.mortalkombat.model.Kingdom;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LocationTo  extends BaseTo<Integer>  {

    private Kingdom kingdom;

    public LocationTo(Integer id) {
        super(id);
    }
}
