/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.model.authorization.v1beta1.DoneableLocalSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.v1beta1.DoneableSelfSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.v1beta1.DoneableSelfSubjectRulesReview;
import io.fabric8.kubernetes.api.model.authorization.v1beta1.DoneableSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.v1beta1.LocalSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.v1beta1.SelfSubjectAccessReview;
import io.fabric8.kubernetes.api.model.authorization.v1beta1.SelfSubjectRulesReview;
import io.fabric8.kubernetes.api.model.authorization.v1beta1.SubjectAccessReview;
import io.fabric8.kubernetes.client.dsl.Createable;
import io.fabric8.kubernetes.client.dsl.internal.LocalCreateOnlyResourceReviewOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.CreateOnlyResourceOperationsImpl;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.OkHttpClient;

public class V1beta1AuthorizationAPIGroupClient extends BaseClient implements V1beta1AuthorizationAPIGroupDSL {

  public static final String AUTHORIZATION_APIGROUP = "authorization.k8s.io";
  public static final String AUTHORIZATION_APIVERSION = "v1beta1";

  public V1beta1AuthorizationAPIGroupClient() {
    super();
  }

  public V1beta1AuthorizationAPIGroupClient(OkHttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

  @Override
  public Createable<SelfSubjectAccessReview, SelfSubjectAccessReview, DoneableSelfSubjectAccessReview> selfSubjectAccessReview() {
    return new CreateOnlyResourceOperationsImpl<>(getHttpClient(), getConfiguration(), AUTHORIZATION_APIGROUP, AUTHORIZATION_APIVERSION, Utils.getPluralFromKind(SelfSubjectAccessReview.class.getSimpleName()), SelfSubjectAccessReview.class);
  }

  @Override
  public Createable<SubjectAccessReview, SubjectAccessReview, DoneableSubjectAccessReview> subjectAccessReview() {
    return new CreateOnlyResourceOperationsImpl<>(getHttpClient(), getConfiguration(), AUTHORIZATION_APIGROUP, AUTHORIZATION_APIVERSION, Utils.getPluralFromKind(SubjectAccessReview.class.getSimpleName()), SubjectAccessReview.class);
  }

  @Override
  public LocalCreateOnlyResourceReviewOperationsImpl<LocalSubjectAccessReview, DoneableLocalSubjectAccessReview> localSubjectAccessReview() {
    return new LocalCreateOnlyResourceReviewOperationsImpl<>(getHttpClient(), getConfiguration(), AUTHORIZATION_APIGROUP, AUTHORIZATION_APIVERSION, Utils.getPluralFromKind(LocalSubjectAccessReview.class.getSimpleName()), LocalSubjectAccessReview.class);
  }

  @Override
  public Createable<SelfSubjectRulesReview, SelfSubjectRulesReview, DoneableSelfSubjectRulesReview> selfSubjectRulesReview() {
    return new CreateOnlyResourceOperationsImpl<>(getHttpClient(), getConfiguration(), AUTHORIZATION_APIGROUP, AUTHORIZATION_APIVERSION, Utils.getPluralFromKind(SelfSubjectRulesReview.class.getSimpleName()), SelfSubjectRulesReview.class);
  }
}
