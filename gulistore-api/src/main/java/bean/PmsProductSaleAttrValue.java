package bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PmsProductSaleAttrValue implements Serializable {

  @Column
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private Long productId;

  @Column
  private Long saleAttrId;

  @Column
  private String saleAttrValueName;

  @Transient
  private int isChecked;
}
