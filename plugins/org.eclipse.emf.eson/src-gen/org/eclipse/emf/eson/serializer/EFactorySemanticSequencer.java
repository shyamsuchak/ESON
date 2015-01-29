package org.eclipse.emf.eson.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eson.eFactory.AnyAttribute;
import org.eclipse.emf.eson.eFactory.Containment;
import org.eclipse.emf.eson.eFactory.CustomNameMapping;
import org.eclipse.emf.eson.eFactory.EFactoryPackage;
import org.eclipse.emf.eson.eFactory.EnumAttribute;
import org.eclipse.emf.eson.eFactory.Factory;
import org.eclipse.emf.eson.eFactory.Feature;
import org.eclipse.emf.eson.eFactory.MultiValue;
import org.eclipse.emf.eson.eFactory.NamespaceImport;
import org.eclipse.emf.eson.eFactory.NewObject;
import org.eclipse.emf.eson.eFactory.PackageImport;
import org.eclipse.emf.eson.eFactory.Reference;
import org.eclipse.emf.eson.services.EFactoryGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class EFactorySemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private EFactoryGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == EFactoryPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case EFactoryPackage.ANY_ATTRIBUTE:
				if(context == grammarAccess.getAnyAttributeRule() ||
				   context == grammarAccess.getAttributeRule() ||
				   context == grammarAccess.getValueRule()) {
					sequence_AnyAttribute(context, (AnyAttribute) semanticObject); 
					return; 
				}
				else break;
			case EFactoryPackage.CONTAINMENT:
				if(context == grammarAccess.getContainmentRule() ||
				   context == grammarAccess.getValueRule()) {
					sequence_Containment(context, (Containment) semanticObject); 
					return; 
				}
				else break;
			case EFactoryPackage.CUSTOM_NAME_MAPPING:
				if(context == grammarAccess.getAnnotationRule() ||
				   context == grammarAccess.getCustomNameMappingRule()) {
					sequence_CustomNameMapping(context, (CustomNameMapping) semanticObject); 
					return; 
				}
				else break;
			case EFactoryPackage.ENUM_ATTRIBUTE:
				if(context == grammarAccess.getAttributeRule() ||
				   context == grammarAccess.getEnumAttributeRule() ||
				   context == grammarAccess.getValueRule()) {
					sequence_EnumAttribute(context, (EnumAttribute) semanticObject); 
					return; 
				}
				else break;
			case EFactoryPackage.FACTORY:
				if(context == grammarAccess.getFactoryRule()) {
					sequence_Factory(context, (Factory) semanticObject); 
					return; 
				}
				else break;
			case EFactoryPackage.FEATURE:
				if(context == grammarAccess.getFeatureRule()) {
					sequence_Feature(context, (Feature) semanticObject); 
					return; 
				}
				else break;
			case EFactoryPackage.MULTI_VALUE:
				if(context == grammarAccess.getMultiValueRule() ||
				   context == grammarAccess.getValueRule()) {
					sequence_MultiValue(context, (MultiValue) semanticObject); 
					return; 
				}
				else break;
			case EFactoryPackage.NAMESPACE_IMPORT:
				if(context == grammarAccess.getNamespaceImportRule()) {
					sequence_NamespaceImport(context, (NamespaceImport) semanticObject); 
					return; 
				}
				else break;
			case EFactoryPackage.NEW_OBJECT:
				if(context == grammarAccess.getNewObjectRule()) {
					sequence_NewObject(context, (NewObject) semanticObject); 
					return; 
				}
				else break;
			case EFactoryPackage.PACKAGE_IMPORT:
				if(context == grammarAccess.getPackageImportRule()) {
					sequence_PackageImport(context, (PackageImport) semanticObject); 
					return; 
				}
				else break;
			case EFactoryPackage.REFERENCE:
				if(context == grammarAccess.getReferenceRule() ||
				   context == grammarAccess.getValueRule()) {
					sequence_Reference(context, (Reference) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     value=ANY
	 */
	protected void sequence_AnyAttribute(EObject context, AnyAttribute semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, EFactoryPackage.Literals.ANY_ATTRIBUTE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EFactoryPackage.Literals.ANY_ATTRIBUTE__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAnyAttributeAccess().getValueANYTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=NewObject
	 */
	protected void sequence_Containment(EObject context, Containment semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, EFactoryPackage.Literals.CONTAINMENT__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EFactoryPackage.Literals.CONTAINMENT__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getContainmentAccess().getValueNewObjectParserRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (eClass=[EClass|QualifiedName] nameFeature=[EAttribute|ID])
	 */
	protected void sequence_CustomNameMapping(EObject context, CustomNameMapping semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, EFactoryPackage.Literals.CUSTOM_NAME_MAPPING__ECLASS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EFactoryPackage.Literals.CUSTOM_NAME_MAPPING__ECLASS));
			if(transientValues.isValueTransient(semanticObject, EFactoryPackage.Literals.CUSTOM_NAME_MAPPING__NAME_FEATURE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EFactoryPackage.Literals.CUSTOM_NAME_MAPPING__NAME_FEATURE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getCustomNameMappingAccess().getEClassEClassQualifiedNameParserRuleCall_2_0_1(), semanticObject.getEClass());
		feeder.accept(grammarAccess.getCustomNameMappingAccess().getNameFeatureEAttributeIDTerminalRuleCall_4_0_1(), semanticObject.getNameFeature());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=[EEnumLiteral|ID]
	 */
	protected void sequence_EnumAttribute(EObject context, EnumAttribute semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, EFactoryPackage.Literals.ENUM_ATTRIBUTE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EFactoryPackage.Literals.ENUM_ATTRIBUTE__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getEnumAttributeAccess().getValueEEnumLiteralIDTerminalRuleCall_1_0_1(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (imports+=NamespaceImport* epackages+=PackageImport* annotations+=Annotation* root=NewObject)
	 */
	protected void sequence_Factory(EObject context, Factory semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (eFeature=[EStructuralFeature|ID] value=Value?)
	 */
	protected void sequence_Feature(EObject context, Feature semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (values+=Value*)
	 */
	protected void sequence_MultiValue(EObject context, MultiValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     importedNamespace=QualifiedNameWithWildcard
	 */
	protected void sequence_NamespaceImport(EObject context, NamespaceImport semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, EFactoryPackage.Literals.NAMESPACE_IMPORT__IMPORTED_NAMESPACE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EFactoryPackage.Literals.NAMESPACE_IMPORT__IMPORTED_NAMESPACE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNamespaceImportAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0(), semanticObject.getImportedNamespace());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (eClass=[EClass|QualifiedName] name=ANY? features+=Feature*)
	 */
	protected void sequence_NewObject(EObject context, NewObject semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ePackage=[EPackage|QualifiedName]
	 */
	protected void sequence_PackageImport(EObject context, PackageImport semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, EFactoryPackage.Literals.PACKAGE_IMPORT__EPACKAGE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EFactoryPackage.Literals.PACKAGE_IMPORT__EPACKAGE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPackageImportAccess().getEPackageEPackageQualifiedNameParserRuleCall_1_0_1(), semanticObject.getEPackage());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=[EObject|QualifiedName]
	 */
	protected void sequence_Reference(EObject context, Reference semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, EFactoryPackage.Literals.REFERENCE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EFactoryPackage.Literals.REFERENCE__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getReferenceAccess().getValueEObjectQualifiedNameParserRuleCall_0_1(), semanticObject.getValue());
		feeder.finish();
	}
}
