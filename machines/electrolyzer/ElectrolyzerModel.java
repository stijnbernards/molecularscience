package molecularscience.machines.electrolyzer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ElectrolyzerModel extends ModelBase
{
	  //fields
	    ModelRenderer floor2;
	    ModelRenderer wall5;
	    ModelRenderer wall4;
	    ModelRenderer wall3;
	    ModelRenderer wall2;
	    ModelRenderer floor1;
	    ModelRenderer anode;
	    ModelRenderer cabel;
	  
	  public ElectrolyzerModel()
	  {
	    textureWidth = 64;
	    textureHeight = 32;
	    
	      floor2 = new ModelRenderer(this, 0, 0);
	      floor2.addBox(0F, 0F, 0F, 16, 1, 16);
	      floor2.setRotationPoint(-8F, 23F, -8F);
	      floor2.setTextureSize(64, 32);
	      floor2.mirror = true;
	      setRotation(floor2, 0F, 0F, 0F);
	      wall5 = new ModelRenderer(this, 0, 0);
	      wall5.addBox(0F, 0F, 0F, 16, 7, 1);
	      wall5.setRotationPoint(-8F, 17F, -8F);
	      wall5.setTextureSize(64, 32);
	      wall5.mirror = true;
	      setRotation(wall5, 0F, 0F, 0F);
	      wall4 = new ModelRenderer(this, 0, 0);
	      wall4.addBox(0F, 0F, 0F, 16, 7, 1);
	      wall4.setRotationPoint(-8F, 17F, 7F);
	      wall4.setTextureSize(64, 32);
	      wall4.mirror = true;
	      setRotation(wall4, 0F, 0F, 0F);
	      wall3 = new ModelRenderer(this, 0, 0);
	      wall3.addBox(0F, 0F, 0F, 1, 7, 16);
	      wall3.setRotationPoint(-8F, 17F, -8F);
	      wall3.setTextureSize(64, 32);
	      wall3.mirror = true;
	      setRotation(wall3, 0F, 0F, 0F);
	      wall2 = new ModelRenderer(this, 0, 0);
	      wall2.addBox(0F, 0F, 0F, 1, 7, 16);
	      wall2.setRotationPoint(7F, 17F, -8F);
	      wall2.setTextureSize(64, 32);
	      wall2.mirror = true;
	      setRotation(wall2, 0F, 0F, 0F);
	      floor1 = new ModelRenderer(this, 0, 0);
	      floor1.addBox(0F, 0F, 0F, 16, 1, 16);
	      floor1.setRotationPoint(-8F, 19F, -8F);
	      floor1.setTextureSize(64, 32);
	      floor1.mirror = true;
	      setRotation(floor1, 0F, 0F, 0F);
	      anode = new ModelRenderer(this, 0, 0);
	      anode.addBox(0F, 0F, 0F, 2, 3, 2);
	      anode.setRotationPoint(-1F, 17F, -1F);
	      anode.setTextureSize(64, 32);
	      anode.mirror = true;
	      setRotation(anode, 0F, 0F, 0F);
	      cabel = new ModelRenderer(this, 0, 0);
	      cabel.addBox(0F, 0F, 0F, 9, 1, 2);
	      cabel.setRotationPoint(-1F, 16F, -1F);
	      cabel.setTextureSize(64, 32);
	      cabel.mirror = true;
	      setRotation(cabel, 0F, 0F, 0F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5);
	    floor2.render(f5);
	    wall5.render(f5);
	    wall4.render(f5);
	    wall3.render(f5);
	    wall2.render(f5);
	    floor1.render(f5);
	    anode.render(f5);
	    cabel.render(f5);
	  }
	  
	  private void setRotation(ModelRenderer model, float x, float y, float z)
	  {
	    model.rotateAngleX = x;
	    model.rotateAngleY = y;
	    model.rotateAngleZ = z;
	  }
	  
	  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
	  }

	}
