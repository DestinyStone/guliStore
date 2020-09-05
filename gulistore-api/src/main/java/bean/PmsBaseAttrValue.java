package bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * @param
 * @return
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PmsBaseAttrValue implements Serializable {
    @Id
    @Column
    private Long id;
    @Column
    private String valueName;
    @Column
    private Long attrId;
    @Column
    private String isEnabled;

    @Transient
    private String urlParam;
}
