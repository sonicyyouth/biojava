package demo;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.biojava.nbio.structure.Atom;
import org.biojava.nbio.structure.StructureException;
import org.biojava.nbio.structure.align.gui.StructureAlignmentDisplay;
import org.biojava.nbio.structure.align.model.Block;
import org.biojava.nbio.structure.align.model.BlockImpl;
import org.biojava.nbio.structure.align.model.BlockSet;
import org.biojava.nbio.structure.align.model.BlockSetImpl;
import org.biojava.nbio.structure.align.model.MultipleAlignment;
import org.biojava.nbio.structure.align.model.Pose;
import org.biojava.nbio.structure.align.model.Pose.PoseMethod;
import org.biojava.nbio.structure.align.util.AtomCache;

/**
 * Demo for visualizing the results of a Multiple Alignment, from a sample MultipleAlignment object.
 * 
 * @author Aleix Lafita
 * 
 */
public class DemoMultipleAlignmentJmol {

	public static void main(String[] args) throws IOException, StructureException {
		
		//Specify the structures to align
		//List<String> names = Arrays.asList("1tim.a", "1vzw", "1nsj", "3tha.a");	//TIM barrels
		List<String> names = Arrays.asList("1mbc", "1hlb", "1thb.a", "1ith.a");		//globins
		
		//Load the CA atoms of the structures
		AtomCache cache = new AtomCache();
		List<Atom[]> atomArrays = new ArrayList<Atom[]>();
		for (String name:names) atomArrays.add(cache.getAtoms(name));
		
		//Here the multiple structural alignment algorithm comes in place to generate the alignment object
		MultipleAlignment fakeMultAln = fakeMultipleAlignment("globins",atomArrays);
		
		//Complete the information of the MultipleAlignment object
		fakeMultAln.setAlgorithmName("fakeAlgorithm");
		fakeMultAln.setStructureNames(names);
		
		StructureAlignmentDisplay.display(fakeMultAln, atomArrays);
	}
	
	private static MultipleAlignment fakeMultipleAlignment(String family, List<Atom[]>atomArrays) throws StructureException{
		
		//Initialize the multiple alignment
		MultipleAlignment fakeMultAln = new MultipleAlignmentImpl();
		BlockSet blockSet = new BlockSetImpl(fakeMultAln);
		Pose pose = new PoseImpl(blockSet);
		Block block = new BlockImpl(blockSet);
		fakeMultAln.setBlockSets(new ArrayList<BlockSet>());
		fakeMultAln.getBlockSets().add(blockSet);
		fakeMultAln.setAtomArrays(atomArrays);
		blockSet.setPose(pose);
		blockSet.setBlocks(new ArrayList<Block>());
		blockSet.getBlocks().add(block);
		block.setAlignRes(new ArrayList<List<Integer>>());
		
		if (family == "globins"){
			
			//Alignment obtained from MUSTANG multiple alignment (just some of the residues, not the whole alignment)
			List<Integer> aligned1 = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,
												   29,30,31,32,33,34,35,36,37,38,
												   123,124,125,126,127,128,129,130,131,132,133,134);
			List<Integer> aligned2 = Arrays.asList(10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,null,27,28,29,30,31,
												   39,40,41,42,43,44,45,46,47,48,
												   133,134,135,136,137,138,139,140,141,142,143,144);
			List<Integer> aligned3 = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,
												   29,30,31,32,33,34,35,36,37,38,
												   117,118,119,120,121,122,123,124,125,126,127,128);
			List<Integer> aligned4 = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,null,17,18,19,20,21,
												   30,31,32,33,34,35,36,37,38,39,
												   121,122,123,124,125,126,127,128,129,130,131,132);
			block.getAlignRes().add(aligned1);
			block.getAlignRes().add(aligned2);
			block.getAlignRes().add(aligned3);
			block.getAlignRes().add(aligned4);
			
			blockSet.updatePose(PoseMethod.REFERENCE);
		}
		return fakeMultAln;
	}

}
