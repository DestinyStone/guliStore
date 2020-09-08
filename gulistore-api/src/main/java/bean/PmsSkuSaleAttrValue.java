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
public class PmsSkuSaleAttrValue implements Serializable {

  @Column
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private Long skuId;

  @Column
  private Long saleAttrId;

  @Column
  private Long saleAttrValueId;

  @Column
  private String saleAttrName;

  @Column
  private String saleAttrValueName;
}
