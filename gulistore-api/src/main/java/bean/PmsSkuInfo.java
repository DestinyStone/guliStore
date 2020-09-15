package bean;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PmsSkuInfo implements Serializable {


  @Column
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private Long spuId;

  @Column
  private String price;

  @Column
  private String skuName;

  @Column
  private String skuDesc;

  @Column
  private String weight;

  @Column
  private Long tmId;

  @Column
  private Long catalog3Id;

  @Column
  private String skuDefaultImg;

  @Transient
  private List<PmsSkuImage> skuImageList;

  @Transient
  private List<PmsSkuSaleAttrValue> skuSaleAttrValueList;

  @Transient
  private List<PmsSkuAttrValue> skuAttrValueList;
}
